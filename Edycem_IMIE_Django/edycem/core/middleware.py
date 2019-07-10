# -*- coding: utf-8 -*-
from django.http import HttpResponse

class EdycemAuthMiddleware:

    def __init__(self, get_response):
        self.get_response = get_response

    def __call__(self, request):
        authenticated = False
        if request.session.get('is_authorized') is True:
            authenticated = True

        if authenticated or request.path == "/" or request.path == "/login":
            response = self.get_response(request)
        else:
            response = HttpResponse("Unauthorized access.",
                                    content_type='text/plain', status=401)
        return response



