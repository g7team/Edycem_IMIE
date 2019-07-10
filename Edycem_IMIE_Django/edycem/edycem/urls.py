from django.conf.urls import url, include
from django.views.generic.base import TemplateView

from django.urls import path

from core.views import HomeView

urlpatterns = [
    path('', HomeView.as_view(), name='home'),

    url(r'', include('core.urls')),
]
