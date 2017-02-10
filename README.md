# Jerry

Login in Heroku:
```sh
heroku login
```

Add Heroku remote:
```sh
heroku git:remote -a [APP_NAME]
```

Deploy in Heroku:
```sh
git push heroku master
```

See the logs:
```sh
heroku logs --tail
```