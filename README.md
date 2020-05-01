# Why Docker Compose?

To start the DB: 
```docker-compose up```.


To shut down the DB + keep everything persisted: ```docker-compose down```.


To shut down the DB + remove everything: ```docker-compose down -v```.


With Docker Compose, we get all the (benefits of Docker)[https://www.linode.com/docs/applications/containers/when-and-why-to-use-docker/] plus more. Docker works by creating a virtual environment(or container) for your code to run. What Docker Compose adds is orchestration and organization of multiple containers. While this tutorial will only spin up a single container for our MySQL instance, Docker Compose can also be used to run all of your various services at once when your project begins to grow out.

## How to Create a MySql Instance with Docker Compose

There is a (blog post)[https://medium.com/@chrischuck35/how-to-create-a-mysql-instance-with-docker-compose-1598f3cc1bee] available on internet which gives enough to get us started
