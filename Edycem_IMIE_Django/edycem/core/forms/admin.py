# -*- coding: utf-8 -*-
from django import forms
from django.contrib.auth.forms import ReadOnlyPasswordHashField, UserCreationForm
from django.utils.translation import gettext_lazy as _

from ..models import Member


class MemberCreateForm(forms.ModelForm):

    class Meta:
        model = Member
        fields = ['email', 'username']
        widgets = {
            'email': forms.EmailInput()
        }

    password1 = forms.CharField(
        label=_("Mot de passe"), widget=forms.PasswordInput)
    password2 = forms.CharField(
        label=_("Confirmation"), widget=forms.PasswordInput)

    def clean_password2(self):
        password1 = self.cleaned_data.get('password1')
        password2 = self.cleaned_data.get('password2')
        if password1 and password2 and password1 != password2:
            raise forms.ValidationError(
                _("Les mots de passe entrés sont différents."))
        return password2

    def save(self, commit=True):
        member = super().save(commit=False)
        member.set_password(self.cleaned_data['password1'])
        member.pk = None
        if commit:
            member.save()
        return member


class MemberUpdateForm(forms.ModelForm):

    class Meta:
        model = Member
        fields = ['email', 'username']

    password = ReadOnlyPasswordHashField(
        label=_("Mot de passe"), help_text=_(
            "Les mots de passe ne sont pas stockés en clair."
            "Vous pouvez cependant changer le mot de passe de ce membre en "
            "utilisant <a href=\"../password/\">ce formulaire</a>."))

    def clean_password(self):
        return self.initial['password']

    def save(self, commit=True):
        member = super().save(commit=False)
        if commit:
            member.save()
        return member

