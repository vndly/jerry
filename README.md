# Jerry

## Example

```java
public class Main extends Jerry
{
    public static void main(String[] args) throws Exception
    {
        Main main = new Main();
        main.start(8080, "com.package.example");
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
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

and the dependency:

```xml
<dependency>
    <groupId>com.github.mauriciotogneri</groupId>
    <artifactId>jerry</artifactId>
    <version>1.0.4</version>
</dependency>
```