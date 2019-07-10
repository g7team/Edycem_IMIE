# -*- coding: utf-8 -*-
from django import forms


class LoginForm(forms.Form):
    username = forms.CharField(label='Utilisateur', max_length=100)
    password = forms.CharField(widget=forms.PasswordInput, label='Mot de passe')


class CreateProjectForm(forms.Form):
    company = forms.CharField(label='Société', max_length=255)
    name = forms.CharField(label='Nom du projet', max_length=255)
    user_id = forms.IntegerField(widget=forms.HiddenInput())

    def __init__(self, *args, **kwargs):
        user_id = kwargs.pop('user_id', None)
        super().__init__(*args, **kwargs)
        if user_id:
            self.fields['user_id'] = user_id
