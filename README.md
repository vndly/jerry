[![License](https://img.shields.io/badge/license-MIT-green.svg)](https://github.com/mauriciotogneri/jerry/blob/master/LICENSE.md)
[![Download](https://api.bintray.com/packages/mauriciotogneri/maven/jerry/images/download.svg)](https://bintray.com/mauriciotogneri/maven/jerry/_latestVersion)

# Jerry

## Example

```java
public class Main
{
    public static void main(String[] args) throws Exception
    {
        Jerry jerry = new Jerry();
        Server server = jerry.create(8080, Mode.LOCAL, "com.package.example");
        
        try
        {
            server.start();
            server.join();
        }
        finally
        {
            server.destroy();
        }
    }
}
```

```java
@Path("/")
public class ProfileResource extends EndPoint
{
    @GET
    @Path("v1/profile")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProfile()
    {
        Profile profile = // obtain profile

        return response(OK, profile);
    }

    @PUT
    @Path("v1/profile")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateProfile(Profile newProfile)
    {
        if (newProfile.isValid())
        {
            Profile profile = // obtain profile;
            profile.update(newProfile);
            
            return response(OK, newProfile);
        }
        else
        {
            return response(BAD_REQUEST);
        }
    }
}
```

```java
public class Profile
{
    public final Long id;
    public final String email;
    public final String name;

    public Profile(Long id, String email, String name)
    {
        this.id = id;
        this.email = email;
        this.name = name;
    }
}
```

```java
@Provider
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileProvider extends EntityProvider<Profile>
{
    public ProfileProvider()
    {
        super(Profile.class);
    }
}
```

## Installation

Add the following code to your **pom.xml**:

```xml
<repositories>
    <repository>
        <id>jcenter</id>
        <url>https://jcenter.bintray.com</url>
    </repository>
</repositories>
```

and the dependency:

```xml
<dependency>
    <groupId>com.mauriciotogneri</groupId>
    <artifactId>jerry</artifactId>
    <version>2.0.0</version>
</dependency>
```

or if you use Gradle:

```groovy
dependencies
{
    compile 'com.mauriciotogneri:jerry:2.0.0'
}
```