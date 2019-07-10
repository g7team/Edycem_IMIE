import datetime

from django.contrib.auth.models import AbstractUser
from django.db import models
from django.utils.translation import ugettext_lazy as _

# Create your models here.
class Project(models.Model):

    id = models.AutoField(primary_key=True)
    societe = models.CharField(max_length=255)
    user = models.IntegerField()
    nom = models.CharField(max_length=255)
    section_project = models.ForeignKey(
        'SectionProject', models.PROTECT, blank=True, null=True,
    )
    # finance = models.ForeignKey(
    #     'Finance', models.PROTECT, blank=True, null=True,
    # )
    partner = models.ForeignKey(
        'Partner', models.PROTECT, blank=True, null=True,
    )
    codir_validation = models.ForeignKey(
        'CodirValidation', models.PROTECT, blank=True, null=True,
    )
    contract = models.ForeignKey(
        'Contract', models.PROTECT, blank=True, null=True,
    )
    insurance = models.ForeignKey(
        'Insurance', models.PROTECT, blank=True, null=True,
    )
    patent = models.ForeignKey(
        'Patent', models.PROTECT, blank=True, null=True,
    )
    confidentialite = models.IntegerField(
    )
    activity = models.ForeignKey(
        'Activity', models.PROTECT, blank=True, null=True,
    )


    def __str__(self):
        return self.nom


class SectionProject(models.Model):

    YEAR_CHOICES = [(r,r) for r in range(1984, datetime.date.today().year+1)]

    PRIORITY_SMALL = 0
    PRIORITY_NORMAL = 1
    PRIORITY_HIGH = 2
    PRIORITY_CHOICES = [
        (PRIORITY_SMALL, _("faible")),
        (PRIORITY_NORMAL, _("normal")),
        (PRIORITY_HIGH, _("urgent")),
    ]

    id = models.AutoField(primary_key=True)
    year = models.IntegerField(
        blank=True, null=True, choices=YEAR_CHOICES, 
    )
    priority = models.PositiveSmallIntegerField(
        default=PRIORITY_NORMAL, blank=True, choices=PRIORITY_CHOICES,
    )
    site = models.CharField(max_length=255)
    deadline = models.DateTimeField()
    goal = models.TextField()
    is_chaire = models.BooleanField(default=False)
    document = models.FileField(upload_to=None, max_length=100)


class SectionFinance(models.Model):

    id = models.AutoField(primary_key=True)
    is_etude = models.BooleanField(default=False)
    office_name = models.CharField(max_length=255)
    roi = models.FloatField(blank=True, null=True)
    example = models.TextField()


class Partner(models.Model):

    id = models.AutoField(primary_key=True)
    name = models.CharField(max_length=255)
    financial_search = models.BooleanField(default=False)
    object_of_partnership = models.TextField()
    technique = models.TextField()


class Insurance(models.Model):

    id = models.AutoField(primary_key=True)
    company_name = models.CharField(max_length=255)
    normalisation = models.CharField(max_length=255)
    is_validated = models.BooleanField(default=False)


class Activity(models.Model):

    PROGRESS_PENDING = 0
    PROGRESS_ONGOING = 1
    PROGRESS_DONE = 2
    PROGRESS_CHOICES = [
        (PROGRESS_PENDING, _("en attente")),
        (PROGRESS_ONGOING, _("en cours")),
        (PROGRESS_DONE, _("terminé")),
    ]

    PRIORITY_SMALL = 0
    PRIORITY_NORMAL = 1
    PRIORITY_HIGH = 2
    PRIORITY_CHOICES = [
        (PRIORITY_SMALL, _("faible")),
        (PRIORITY_NORMAL, _("normal")),
        (PRIORITY_HIGH, _("urgent")),
    ]

    id = models.AutoField(primary_key=True)
    name = models.CharField(max_length=255)
    start_date = models.DateTimeField()
    end_date = models.DateTimeField()
    manager = models.IntegerField()
    progress = models.PositiveSmallIntegerField(
        default=PROGRESS_PENDING, blank=True, choices=PROGRESS_CHOICES,
    )
    priority = models.PositiveSmallIntegerField(
        default=PRIORITY_NORMAL, blank=True, choices=PRIORITY_CHOICES,
    )


class task(models.Model):

    PROGRESS_PENDING = 0
    PROGRESS_ONGOING = 1
    PROGRESS_DONE = 2
    PROGRESS_CHOICES = [
        (PROGRESS_PENDING, _("en attente")),
        (PROGRESS_ONGOING, _("en cours")),
        (PROGRESS_DONE, _("terminé")),
    ]

    id = models.AutoField(primary_key=True)
    name = models.CharField(max_length=255)
    start_date = models.DateTimeField()
    end_date = models.DateTimeField()
    manager = models.IntegerField()
    progress = models.PositiveSmallIntegerField(
        default=PROGRESS_PENDING, blank=True, choices=PROGRESS_CHOICES,
    )


class PrivacyAgreement(models.Model):

    id = models.AutoField(primary_key=True)
    contract_name = models.CharField(max_length=255)
    project_sponsor_company_name = models.CharField(max_length=255)
    project_sponsor_name = models.CharField(max_length=255)
    patent_name = models.CharField(max_length=255)
    contract = models.ForeignKey(
        'Contract', models.PROTECT, blank=True, null=True,
    )


class Contract(models.Model):

    id = models.AutoField(primary_key=True)
    licence_name = models.CharField(max_length=255)
    company_name = models.CharField(max_length=255)
    agreement_product = models.CharField(max_length=255)
    agreement_supply = models.CharField(max_length=255)


class Patent(models.Model):

    id = models.AutoField(primary_key=True)
    name = models.CharField(max_length=255)
    inventor_name = models.CharField(max_length=255)
    INPI_number = models.CharField(max_length=255)
    ownership_rights = models.CharField(max_length=255)


class CodirValidation(models.Model):

    id = models.AutoField(primary_key=True)
    is_positive = models.BooleanField(default=False)
    holding_validation = models.CharField(max_length=255)
