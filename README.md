# 04-practice-hystrix-unit-test
spring cloud hystrix unit test method

workable version of hystrix and also the unit test


1. The propose of this test is to 
- normally, call hello1 will call hello2
- abnormally (in unit test), simulate call hello1 will get hello3 (hystrix fallback)
