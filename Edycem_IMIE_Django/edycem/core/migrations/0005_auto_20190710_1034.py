# Generated by Django 2.2.3 on 2019-07-10 08:34

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('core', '0004_auto_20190708_1211'),
    ]

    operations = [
        migrations.RemoveField(
            model_name='member',
            name='_password',
        ),
        migrations.AlterField(
            model_name='member',
            name='email',
            field=models.EmailField(max_length=255, verbose_name='e-mail'),
        ),
    ]