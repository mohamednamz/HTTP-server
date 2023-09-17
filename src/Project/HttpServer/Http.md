HTTP
---

HTTP is a protocol for communicating between two different parties. The parties in this instance are computers. Typically it is referred to as a communication protocol between a client and a server. However, it is simply a communication protocol between two computers. I've simplified this definition because a computer can be both a server or a client ( or even both )

We will be implementing parts of the protocol to give us an understanding about how these protocols work. 

The HTTP protocol is a request and response model 

A computer sends a request to a message requesting a "resource" and the server responds back.

Once a computer recieves a request, it processes the request and returns a response.

HTTP is a layer 7 protocol.

For now, we will ignore all the layers underneath it; physical, network ( IP ) transport ( TCP )  

HTTP is a text protocol, the data that is sent is a string.

---
### The Request

We will simplify the request for a HTTP message and focus on the first part, the request line 

```GET /testing HTTP/1.1```

A `HTTP Verb/Method` followed by a `path` followed by a `version`

Using the `HTTP Verb` combined with the `path` we should be able to determined where a resource is if it exists. 

The same path can have different verbs  

```GET /testing HTTP 1.1```

```PUT /testing HTTP 1.1```


----

### The Verb

The verb is the simplest part - it is also called the HTTPMethod

There are six ( that I know of ) 

`GET`
`POST`
`PUT`
`DELETE`
`HEAD`
`OPTIONS`


---


### The Path

The path is not always simple and can have quries in it

This is how we can embed queries inside a route

```/testing?name=umar```

We can have multiple qeuries inside a route

```/testing?name=umar&lastname=karimaaadi```

--------

We will be creating two components in our HTTP Server

The first component is the `Router`

The second component is the `HTTPRequestParser`

I have created a Youtube video that explains the components that I have outlined for you

Your task is to complete the methods both in the `Router` and the `HTTPRequestParser`



 








