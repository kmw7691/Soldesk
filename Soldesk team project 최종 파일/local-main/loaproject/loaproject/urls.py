"""
URL configuration for loaproject project.

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/4.2/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""

from django.contrib import admin
from django.urls import path, re_path
import loaTier.views, loaCalc.views
from django.conf import settings
from django.views.static import serve

handler400 = 'loaTier.views.error400'
handler404 = 'loaTier.views.error404'
handler500 = 'loaTier.views.error500'

urlpatterns = [
    path("admin/", admin.site.urls),
    path("", loaTier.views.home),
    path('make/<str:group>/', loaTier.views.make, name='tierMaker'),
    path('res/<str:group>/<str:id>', loaTier.views.personal, name="userResult"),
    path('res/all/', loaTier.views.statitcs, name="allResult"),
    path('input/', loaCalc.views.gotoCalculate, name="input"),
    path('calc/', loaCalc.views.calcPage, name="Calculator"),
    re_path(r'^static/(?P<path>.*)', serve, kwargs={'insecure': True}),
]
