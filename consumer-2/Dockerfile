FROM python:3

ENV APP /app

RUN mkdir $APP

WORKDIR $APP

EXPOSE 81

COPY requirements.txt .

RUN pip install -r requirements.txt

COPY . .

CMD [ "python3", "app.py" ]