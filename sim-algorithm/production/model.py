class Response:
    def __init__(self, username, email):
        self._username = username
        self._email = email

    @property
    def username(self):
        return self._username

    @username.setter
    def username(self, value):
        self._username = value

    @property
    def email(self):
        return self._email

    @email.setter
    def email(self, value):
        self._email = value

    def __repr__(self):
        return f'<User {self._username}>'
