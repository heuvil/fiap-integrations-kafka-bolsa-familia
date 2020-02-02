FROM python:3

ENV PYTHONUNBUFFERED 1

ENV APP /app

RUN mkdir $APP

WORKDIR $APP

EXPOSE 81

COPY requirements.txt .

RUN pip install -r requirements.txt

COPY . .