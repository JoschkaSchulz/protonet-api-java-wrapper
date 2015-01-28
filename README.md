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
:white_check_mark: add POJO Objects, remove json  
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

With that Protonet-Object you are able to use the REST interface and to get a result as a JSON String. I also added some examples in the file [APIExample.java](https://github.com/protonet/protonet-api-java-wrapper/blob/master/src/de/thathalas/protonet/APIExample.java) and I hope it's straightforward to use to get results from the Protonet boxes.

### Example of API Test Output
    --[ Me
    Me me                      : User [id=1, role=admin, username=joschka.schulz]
    Me login_tokens            : JAvsAR5yQsQ6VfDxSxgH
    --[ Devices
    Devices create             : UserDevice [id=14, token=aaaaaaab, platform=android]
    Devices update_device      : true
    Devices delete             : true
    --[ Users
    Users index                : [User [id=1, role=admin, username=joschka.schulz], User [id=2, role=guest, username=chuck.norris]]
    Users show                 : User [id=1, role=admin, username=joschka.schulz]
    --[ Projects
    Projects index             : [Project [id=34, name=APITestGroup66384], Project [id=4, name=miep?], Project [id=33, name=APITestGroup65546], Project [id=32, name=APITestGroup434723], Project [id=31, name=APITestGroup704767], Project [id=30, name=APITestGroup119833], Project [id=29, name=APITestGroup54083], Project [id=28, name=APITestGroup303572], Project [id=27, name=APITestGroup40516], Project [id=26, name=APITestGroup468386], Project [id=25, name=APITestGroup934292], Project [id=24, name=APITestGroup76522], Project [id=23, name=APITestGroup754713], Project [id=22, name=APITestGroup788], Project [id=21, name=APITestGroup66073], Project [id=20, name=APITestGroup733910], Project [id=19, name=APITestGroup837749], Project [id=18, name=APITestGroup362774], Project [id=17, name=APITestGroup405196], Project [id=16, name=APITestGroup766164], Project [id=15, name=APITestGroup886931], Project [id=14, name=APITestGroup203862], Project [id=13, name=APITestGroup424357], Project [id=12, name=APITestGroup983909], Project [id=11, name=APITestGroup271358], Project [id=10, name=APITestGroup830293], Project [id=9, name=APITestGroup480958], Project [id=8, name=APITestGroup638300], Project [id=7, name=APITestGroup248722], Project [id=1, name=Epic Cat Gif Share Group], Project [id=6, name=APITestGroup738649], Project [id=5, name=APITestGroup252273], Project [id=2, name=eins], Project [id=3, name=zwei]]
    Projects show              : Project [id=1, name=Epic Cat Gif Share Group]
    Projects create            : Project [id=35, name=APITestGroup606140]
    --[ Meeps
    Meeps index projects       : [Meep [id=255, message=Hallo alle], Meep [id=252, message=Hallo alle], Meep [id=249, message=Hallo alle], Meep [id=246, message=Hallo alle], Meep [id=243, message=Hallo alle], Meep [id=240, message=Hallo alle], Meep [id=237, message=Hallo alle], Meep [id=234, message=Hallo alle], Meep [id=231, message=Hallo alle], Meep [id=228, message=Hallo alle], Meep [id=225, message=Hallo alle], Meep [id=222, message=Hallo alle], Meep [id=219, message=Hallo alle], Meep [id=206, message=Hallo alle], Meep [id=203, message=Hallo alle], Meep [id=200, message=Hallo alle], Meep [id=197, message=Hallo alle], Meep [id=192, message=Hallo alle], Meep [id=189, message=Hallo alle], Meep [id=186, message=Hallo alle], Meep [id=183, message=Hallo alle], Meep [id=180, message=Hallo alle], Meep [id=177, message=Hallo alle], Meep [id=174, message=Hallo alle], Meep [id=171, message=Hallo alle], Meep [id=167, message=do not delete, java API test!]]
    Meeps index topics         : [Meep [id=256, message=Hier kommen mehr...], Meep [id=253, message=Hier kommen mehr...], Meep [id=250, message=Hier kommen mehr...], Meep [id=247, message=Hier kommen mehr...], Meep [id=244, message=Hier kommen mehr...], Meep [id=241, message=Hier kommen mehr...], Meep [id=238, message=Hier kommen mehr...], Meep [id=235, message=Hier kommen mehr...], Meep [id=232, message=Hier kommen mehr...], Meep [id=229, message=Hier kommen mehr...], Meep [id=226, message=Hier kommen mehr...], Meep [id=223, message=Hier kommen mehr...], Meep [id=220, message=Hier kommen mehr...], Meep [id=207, message=Hier kommen mehr...], Meep [id=204, message=Hier kommen mehr...], Meep [id=201, message=Hier kommen mehr...], Meep [id=198, message=Hier kommen mehr...], Meep [id=193, message=Hier kommen mehr...], Meep [id=190, message=Hier kommen mehr...], Meep [id=187, message=Hier kommen mehr...], Meep [id=184, message=Hier kommen mehr...], Meep [id=181, message=Hier kommen mehr...], Meep [id=178, message=Hier kommen mehr...], Meep [id=175, message=Hier kommen mehr...], Meep [id=172, message=Hier kommen mehr...], Meep [id=168, message=do not delete, you know ^^]]
    Meeps index private chats  : [Meep [id=257, message=moin], Meep [id=254, message=moin], Meep [id=251, message=moin], Meep [id=248, message=moin], Meep [id=245, message=moin], Meep [id=242, message=moin], Meep [id=239, message=moin], Meep [id=236, message=moin], Meep [id=233, message=moin], Meep [id=230, message=moin], Meep [id=227, message=moin], Meep [id=224, message=moin], Meep [id=221, message=moin], Meep [id=218, message=test], Meep [id=216, message=>_>], Meep [id=211, message=tsts], Meep [id=210, message=meep with file], Meep [id=209, message=test], Meep [id=208, message=moin], Meep [id=205, message=moin], Meep [id=202, message=moin], Meep [id=199, message=moin], Meep [id=194, message=moin], Meep [id=191, message=moin], Meep [id=188, message=moin], Meep [id=185, message=moin], Meep [id=182, message=moin], Meep [id=179, message=moin], Meep [id=176, message=moin], Meep [id=173, message=moin], Meep [id=170, message=do not delete!], Meep [id=169, message=test]]
    Meeps create projects      : Meep [id=258, message=Hallo alle]
    Meeps create topics        : Meep [id=259, message=Hier kommen mehr...]
    Meeps create private chats : Meep [id=260, message=moin]
    Meeps show projects        : Meep [id=167, message=do not delete, java API test!]
    Meeps show topics          : Meep [id=168, message=do not delete, you know ^^]
    Meeps show private chats   : Meep [id=170, message=do not delete!]
    --[ Subscriptions
    Subscriptions show Project : Subscription [id=1, lastSeenMeepNo=2]
    Subscriptions show Topic   : Subscription [id=159, lastSeenMeepNo=27]
    Subscriptions show p.C     : Subscription [id=160, lastSeenMeepNo=31]
    Subscriptions update Proje : {}
    Subscriptions update Topic : {}
    Subscriptions update p.C.  : {}
    --[ Private Chats
    Private Chats index        : [ProtonetPrivateChat [id=1, otherUsers=[User [id=2, role=guest, username=chuck.norris]]]]
    Private Chats show         : ProtonetPrivateChat [id=1, otherUsers=[User [id=2, role=guest, username=chuck.norris]]]
    Private Chats create       : ProtonetPrivateChat [id=1, otherUsers=[User [id=2, role=guest, username=chuck.norris]]]
    Private Chats update       : {}
