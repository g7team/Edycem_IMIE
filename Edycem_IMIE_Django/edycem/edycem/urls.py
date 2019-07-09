from django.conf.urls import url, include
from django.views.generic.base import TemplateView

from django.contrib import admin
from django.urls import path

urlpatterns = [
    path('admin/', admin.site.urls),
    path('accounts/', include('django.contrib.auth.urls')),
    path('', TemplateView.as_view(template_name='home.html'), name='home'),

    url(r'', include('core.urls')),
]
