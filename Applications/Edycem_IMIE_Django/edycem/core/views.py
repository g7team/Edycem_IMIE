import requests

from django.contrib import messages
from django.http import Http404
from django.shortcuts import render, redirect
from django.urls import reverse
from django.views.generic.base import TemplateView
from django.views.generic.edit import FormView

from .forms import (
    LoginForm, CreateProjectForm, UpdateProjectPart1Form, UpdateProjectPart2Form,
)

# Create your views here.
class HomeView(TemplateView):

    template_name = "home.html"

    def get_context_data(self, **kwargs):
        print(self.request.session['user'])
        response = requests.get(
            'https://5d25a0f7d92454001493175d.mockapi.io/edycem/projet/')
        kwargs['project_list'] = response.json()
        is_authenticated = self.request.session.get('is_authorized')
        kwargs['is_authenticated'] = is_authenticated
        user = None
        if is_authenticated and self.request.session['user']:
            kwargs['user'] = self.request.session['user']
        return super().get_context_data(**kwargs)


class LoginView(FormView):

    template_name = "registration/login.html"
    form_class = LoginForm

    def post(self, request, *args, **kwargs):
        form = self.get_form()
        if form.is_valid():
            return self.form_valid(form)
        else:
            return self.form_invalid(form)

    def get_success_url(self):
        return reverse('home')

    def form_valid(self, form):
        response = super().form_valid(form)
        username = form.cleaned_data['username']
        password = form.cleaned_data['password']
        response = requests.post(
            'http://5d25a0f7d92454001493175d.mockapi.io/edycem/user/1/login/', 
            data = {'username': username, 'password': password})
        response = response.json()
        if response and response != "Not found":
            self.request.session['is_authorized'] = True
            self.request.session['user'] = {
              "id" : response['user_id'],
              "name": response['name'],
              "surname": response['surname'],
              "mail": response['mail'],
            }
        return super().form_valid(form)

    def form_invalid(self, form):
        self.form = form
        return self.get(self.request, *self.args, **self.kwargs)


def logout_view(request):
    request.session['is_authorized'] = False
    request.user = {}
    return redirect('home')


class CreateProjectView(FormView):

    template_name = "project/create.html"
    form_class = CreateProjectForm

    def post(self, request, *args, **kwargs):
        form = self.get_form()
        if form.is_valid():
            return self.form_valid(form)
        else:
            return self.form_invalid(form)

    def get_success_url(self):
        return reverse('home')

    def form_valid(self, form):
        response = super().form_valid(form)
        company = form.cleaned_data['company']
        user_id = self.request.session['user']['id']
        name = form.cleaned_data['name']
        response = requests.post(
            'http://5d25a0f7d92454001493175d.mockapi.io/edycem/projet/', 
            data = {
              "societe": company,
              "user_id": user_id,
              "name": name
            }
        )
        response = response.json()
        if not response or response == "Not found":
            raise Http404
        else:
            messages.success(self.request, 'Le projet a bien été créé !')
        return super().form_valid(form)

    def form_invalid(self, form):
        self.form = form
        return self.get(self.request, *self.args, **self.kwargs)


class UpdateProjectPart1View(FormView):

    template_name = "project/update_part1.html"
    form_class = UpdateProjectPart1Form

    def post(self, request, *args, **kwargs):
        form = self.get_form()
        if form.is_valid():
            return self.form_valid(form)
        else:
            return self.form_invalid(form)

    def get_success_url(self):
        return reverse('update_project_part2')

    def form_valid(self, form):
        response = super().form_valid(form)
        company = form.cleaned_data['company']
        name = form.cleaned_data['name']
        response = requests.patch(
            'http://5d25a0f7d92454001493175d.mockapi.io/edycem/projet/', 
            data = {
              "societe": company,
              "name": name
            }
        )
        response = response.json()
        if not response or response == "Not found":
            raise Http404
        return super().form_valid(form)

    def form_invalid(self, form):
        self.form = form
        return self.get(self.request, *self.args, **self.kwargs)


class UpdateProjectPart2View(FormView):

    template_name = "project/update_part2.html"
    form_class = UpdateProjectPart2Form
