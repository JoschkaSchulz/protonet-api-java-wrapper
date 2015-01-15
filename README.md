# Protonet API Java Wrapper
author: Joschka Schulz

## Some words before
This wrapper of the Protonet API is a hobby open source project of mine, so please feel free to report issus and I will fix that if I find some time for that.

## What can this Wrapper do?
My goal is to get a 100% functionallity of the Protonet REST API but I can't promise. I will try to create a small overview over all interfaces that are implemented.

## What's up next?  
:negative_squared_cross_mark: javadoc/comments to the methods  
:negative_squared_cross_mark: Some easier methods to ask which meeps are new  
:negative_squared_cross_mark: move to Gradle  
:white_check_mark: private Chat to Many Wrapper

:white_check_mark: done / :negative_squared_cross_mark: in work

## How to use

### Dependencies
This project needs the librarys given in the lib folder and the json library from http://www.json.org/java/index.html.

### Usage
Just create a .jar file or link the project within eclipse.

After that you have to create a new Protonet Object:

    ProtonetWrapper protonet = new ProtonetWrapper("http://yourbox.protonet.info");
    protonet.getToken("email", "password", "name of your application");

With that Protonet-Object you are able to use the REST interface and to get a result as a JSON String. I also added some examples in the file APIExample.java and I hope it's straightforward to use to get results from the Protonet boxes.
