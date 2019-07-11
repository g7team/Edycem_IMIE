# -*- coding: utf-8 -*-
from django import forms


class LoginForm(forms.Form):
    username = forms.CharField(label='Utilisateur', max_length=100)
    password = forms.CharField(widget=forms.PasswordInput, label='Mot de passe')

class CreateProjectForm(forms.Form):
    company = forms.CharField(label='Société', max_length=255)
    name = forms.CharField(label='Nom du projet', max_length=255)

class UpdateProjectPart1Form(forms.Form):
    company = forms.CharField(label='Société', max_length=255)
    name = forms.CharField(label='Nom du projet', max_length=255)

class UpdateProjectPart2Form(forms.Form):
    PRIORITY_CHOICE_LIST = [
        "URGENT", "NORMAL", "WEAK"
    ]
    CIR_year = forms.IntegerField(label='Année d\'éligibilité CIR')
    priority = forms.ChoiceField(choices=PRIORITY_CHOICE_LIST)
    chaire = forms.CharField(label='CHAIRE', max_length=255)
    deadline = forms.DateField(label='échéance')
    goal = forms.CharField(widget=forms.Textarea, label='objectif')
    confidentiality = forms.BooleanField(label='confidentialité')
    licence = forms.BooleanField(label='license')
    patent = forms.BooleanField(label='brevet')
