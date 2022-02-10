# basicBankingSystemBackend 
the website [demo](https://youssefagagg.github.io/basicBankingSystemFrontend/) <br>
the frontend repo for the app [frontend](https://github.com/YoussefAgagg/basicBankingSystemFrontend)<br>

## about
rest api for task 1 in the Sparks Foundation Internship for Web Development

Task 1 Requirements:
* Create a simple dynamic website which has the following specs.
* Start with creating a dummy data in database for upto 10 customers . Database options : Mysql , Mongo , Postgres , etc. Customers table will have basic fields such as name , email , current balance etc. Transfers table will record all transfers happened .
* Flow : Home Page > View all Customers > Select and View one Customer > Transfer Money > Select customer to transfer to > View all Customers .
* No Login Page . No User Creation . Only transfer of money between multiple users .
* Host the website at 000webhost , github.io , heroku app or any other free hosting provider . Check in code in gitlab .

## Technologies

* java 8
* springboot
* spring data


## api use:
### get requests
* to get all customer accounts use (https://basic-banking-system-demo.herokuapp.com/account/all)

* to get a specific customer account use: (https://basic-banking-system-demo.herokuapp.com/account/1)
### post request
* to transfer money between two accounts use (https://basic-banking-system-demo.herokuapp.com/transfer) in a post request with body:<br>
`
{
"transferFrom": 1, 
"transferTo": 2,
 "amount": 255, 
 "transferDate": "2022-02-10"
 }
`

