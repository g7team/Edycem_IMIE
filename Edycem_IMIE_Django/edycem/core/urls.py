# -*- coding: utf-8 -*-
from django.conf.urls import url
from django.urls import path, include

from . import views


urlpatterns = [
    path('login', views.LoginView.as_view(), name='login'),
    path('logout', views.logout_view, name='logout'),
    path('create-project', views.CreateProjectView.as_view(), name='create_project'),
]
