from django.contrib import admin
from django.contrib.auth.admin import UserAdmin as BaseUserAdmin

# Register your models here.
from .models import Member
from .forms.admin import MemberUpdateForm, MemberCreateForm


@admin.register(Member)
class MemberAdmin(BaseUserAdmin):
    form = MemberUpdateForm
    add_form = MemberCreateForm
    readonly_fields = []
    list_display = ['username', 'email']
    list_display_links = ['username', 'email']
    list_filter = ['user_type']
    search_fields = ['email', 'username']
    ordering = ['-id']
