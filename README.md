# Yubikey OTP Login

Strong login with Yubikey using Yubico OTP. Get your Yubikey from [Yubico](https://www.yubico.com/products/yubikey-hardware/) 

### Configure Yubico Client
- Get an API key from [https://upgrade.yubico.com/getapikey/](https://upgrade.yubico.com/getapikey/) and make a note of the client id and key.

![Figure: Yubico API key registration](docs/images/yubico-api-key.png)

- Sign in to portal as admin
- Navigate to Control Panel -> Configuration -> System Settings -> Other -> Yubico Client
- Enter client id and key. WSAPI urls are optional

![Figure: Yubico Client Settings](docs/images/yubico-client-settings.png)

Now the Yubico Client is configured and available for use.

### Enable Yubikey authentication
- Sign in to portal as admin
- Navigate to Control Panel -> Configuration -> Instance Settings -> Authentication -> Yubikey
- Check enabled and click Save

![Figure: Yubikey Authentication](docs/images/authentication.png)

### Register a key with account
- Sign in
- Navigate to My Account -> Yubikey
- Click Add Key
- Enter a name for the key
- Generate a new OTP
- Click Add to register the key

![Figure: Yubikey registration](docs/images/register-yubikey.png)

### Login using Yubikey

If you have successfully enabled Yubikey authentication and registered your Yubikey with an account you can use it to login to that account.

![Figure: Sign in with Yubikey enabled](docs/images/signin.png)

Press the OTP generation button on your Yubikey.

![Figure: Yubikey OTP login](docs/images/signin-yubikey-otp.png)