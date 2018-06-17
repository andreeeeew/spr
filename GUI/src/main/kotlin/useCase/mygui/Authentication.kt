package useCase.mygui

class Authentication {

    private var username: String? = null
    private var password: String? = null

    init {
        username = "myuser"
        password = "mypass"
    }

    fun authenticate(username: String, password: String): Boolean? {
        println("in authenticate username is ${username} and password is ${password}")
        return this.username == username && this.password == password
    }

}