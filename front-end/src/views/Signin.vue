<template>
    <div class="container">
        <div id="nav" class="row">
            <form class="form-signin">
                <img
                    class="mb-4"
                    src="https://getbootstrap.com/docs/4.0/assets/brand/bootstrap-solid.svg"
                    alt=""
                    width="72"
                    height="72">
                    <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
                    <label for="inputEmail" class="sr-only">Email address</label>
                    <input
                        type="email"
                        id="inputEmail"
                        class="form-control"
                        placeholder="Email address"
                        required="required"
                        autofocus="autofocus">

                        <label for="inputPassword" class="sr-only">Password</label>
                        <input
                            type="password"
                            id="inputPassword"
                            class="form-control"
                            placeholder="Password"
                            required="required">
                            <div class="checkbox mb-3">
                                <label>
                                    <input type="checkbox" value="remember-me">
                                        Remember me
                                </label>
                                </div>
                                <button class="form-button btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                                <p class="mt-5 mb-3 text-muted">&copy; WE ARE THE HOME</p>
                            </form>
                        </div>
                    </div>
</template>
<script>
    export default {}
</script>

<style scoped>
.container {
    display: -ms-flexbox;
    display: -webkit-box;
    display: flex;
    -ms-flex-align: center;
    -ms-flex-pack: center;
    -webkit-box-align: center;
    align-items: center;
    -webkit-box-pack: center;
    justify-content: center;
    padding-top: 40px;
    padding-bottom: 120px;
    background-color: #f5f5f5;
}


.form-signin {
    width: 100%;
    height: 100%;
    max-width: 330px;
    padding: 15px;
    margin: 0 auto;
}

.form-signin .checkbox {
    font-weight: 400;
}
.form-signin .form-control {
    position: relative;
    box-sizing: border-box;
    height: auto;
    padding: 10px;
    font-size: 16px;
}

.form-signin .form-control:focus {
    z-index: 2;
}
.form-signin input[type="email"] {
    margin-bottom: -1px;
    border-bottom-right-radius: 0;
    border-bottom-left-radius: 0;
}
.form-signin input[type="password"] {
    margin-bottom: 10px;
    border-top-left-radius: 0;
    border-top-right-radius: 0;
}


</style>