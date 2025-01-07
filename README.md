  
  # ARTgallery

**Art is not what you see, but what you make others see.** 

ARTgallery is a simple application that display art across the word with it's information.


## API Reference (BackEnd)

For more inforamtion of EndPoint you can access swagger via url
```
http://{ip}:{port}/swagger-ui/index.html
```

#### Get all Art-Works

```http
  GET /arkwork
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `page` | `integer` | **Required**. pagination of result |

#### Get Art-Work by Id

```http
  GET /artwork/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `integer` | **Required**. Id of item to fetch |

#### Find Art-Works by criteria

```http
  GET /artwork/search/{query}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `query`      | `string` | **Required**. keyword to find |
| `page`      | `integer` | **Required**. pagination of result |





## Installation & Running

### Backend

* **Java 22**
* **maven**
* **Spring Boot 3.4.1**

```bash
  mvn clean
  mvn package
  java -jar target/app.jar
```
### Frontend

* **NodeJs 22.11.0**
* **Angular 19.0.0**
* **Angular/CLI 19.0.6**

```bash
  npm install
  ng s
```
    
## Deployment

* Manuel Deployment : Starting with building the images then run it


```bash
  docker build -t artwork-backend ./interview/
  docker build -t artwork-frontend ./Interview-Front/

  docker run -p 8080:8080 artwork-backend
  docker run -p 80:80 artwork-frontend
```

* Automatique Deployment : 

  Using **docker-compose.yml** file you can build and deploy at the same time then monitor logs using :

```bash
  docker-compose up -d --build
  docker-compose logs -f
```

OR

  you can use jenkins ( **jenkins.groovy** ) script that call **docker-compose.yml** file