# -*- coding: utf-8 -*-
from django.conf.urls import url
from django.urls import path, include

from . import views


urlpatterns = [
    path('login', views.LoginView.as_view(), name='login'),
    path('logout', views.logout_view, name='logout'),
    path('create-project', views.CreateProjectView.as_view(), name='create_project'),
    path('update-project/<int:project_id>/part-1', 
         views.UpdateProjectPart1View.as_view(),
         name='update_project_part1'),
    path('update-project/<int:project_id>/part-2',
         views.UpdateProjectPart2View.as_view(),
         name='update_project_part2'),
]
