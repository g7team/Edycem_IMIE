# -*- coding: utf-8 -*-
from django.conf.urls import url
from django.urls import path, include

from . import views


urlpatterns = [
    path('login', views.LoginView.as_view(), name='login'),
    path('logout', views.logout_view, name='logout'),
    path('create_project/', views.CreateProjectView.as_view(), name='create_project'),
    #
    # path('', ViewListBox.as_view(), name='box_list'),
    # path('detail/<int:pk>', ViewDetailBox.as_view(), name='box_detail'),
    # path('update/<int:pk>', ViewUpdateBox.as_view(), name='box_update'),
    # path('create/', ViewCreateBox.as_view(), name='box_create'),
    # path('delete/<int:pk>', ViewDeleteBox.as_view(), name='box_delete'),
]
