# Generated by Django 2.2.3 on 2019-07-08 09:58

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('core', '0001_initial'),
    ]

    operations = [
        migrations.RemoveField(
            model_name='member',
            name='user_name',
        ),
    ]
