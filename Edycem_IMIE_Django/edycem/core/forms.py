# -*- coding: utf-8 -*-
from django import forms


class LoginForm(forms.Form):
    username = forms.CharField(label='Utilisateur', max_length=100)
    password = forms.CharField(widget=forms.PasswordInput, label='Mot de passe')


class CreateProjectForm(forms.Form):
    company = forms.CharField(label='Société', max_length=255)
    name = forms.CharField(label='Nom du projet', max_length=255)
