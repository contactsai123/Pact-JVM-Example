# UserService

| Description    | Value |
| -------------- | ----- |
| Date Generated | Fri Nov 30 22:27:12 IST 2018 |
| Pact Version   | 3.5.22 |

## Verifying a pact between _ConsumerA_ and _UserService_

From Pact Broker https://sivasailem.pact.dius.com.au/pacts/provider/UserService/consumer/ConsumerA/version/2.0.1
Given **There is a user with empid 214 available in the Consumer A system**  
&nbsp;&nbsp;&nbsp;&nbsp;<span style='color: yellow'>WARNING: State Change ignored as there is no stateChange URL</span>  
A request for age for emp id 214  
&nbsp;&nbsp;returns a response which  
&nbsp;&nbsp;&nbsp;&nbsp;has status code **200** (<span style='color:green'>OK</span>)  
&nbsp;&nbsp;&nbsp;&nbsp;includes headers  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"**Content-Type**" with value "**application/json**" (<span style='color:green'>OK</span>)  
&nbsp;&nbsp;&nbsp;&nbsp;has a matching body (<span style='color:green'>OK</span>)  
## Verifying a pact between _ConsumerB_ and _UserService_

From Pact Broker https://sivasailem.pact.dius.com.au/pacts/provider/UserService/consumer/ConsumerB/version/2.0.1
Given **There is a user with empid 214 available in the Consumer B system**  
&nbsp;&nbsp;&nbsp;&nbsp;<span style='color: yellow'>WARNING: State Change ignored as there is no stateChange URL</span>  
A request for name for emp id 214  
&nbsp;&nbsp;returns a response which  
&nbsp;&nbsp;&nbsp;&nbsp;has status code **200** (<span style='color:green'>OK</span>)  
&nbsp;&nbsp;&nbsp;&nbsp;includes headers  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"**Content-Type**" with value "**application/json**" (<span style='color:green'>OK</span>)  
&nbsp;&nbsp;&nbsp;&nbsp;has a matching body (<span style='color:red'>FAILED</span>)  

| Path | Failure |
| ---- | ------- |
|$|Expected name='Peter' but was missing|

Diff:

```diff
{
+    "legalname": "Peter",
    "empid": "214",
-    "name": "Peter"
+    "age": 30,
+    "salary": 53609
}
```

