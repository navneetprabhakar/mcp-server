# mcp-server

Model Context Protocol Server with Spring AI

## Overview

**mcp-server** is a Spring Boot application implementing the Model Context Protocol (MCP) using Spring AI. It provides a RESTful API and MCP server endpoint for time utilities and can be extended for AI-driven context management and other services.

## Features

- ✅ MCP server implementation using Spring AI
- ✅ REST API for current time utilities
- ✅ Easily extensible for additional AI or utility endpoints
- ✅ Built with Java 21 and Spring Boot 3.5.10
- ✅ Spring AI 1.1.2 integration
- ✅ Lombok for reduced boilerplate code

## Prerequisites

- **Java 21** or higher
- **Maven 3.9+** (or use the included Maven wrapper)

## Setup & Build

Clone the repository and build using Maven:

```bash
git clone <your-repo-url>
cd mcp-server
./mvnw clean install
```

## Running the Server

You can run the application using Maven or the generated JAR:

### Using Maven Wrapper
```bash
./mvnw spring-boot:run
```

### Using JAR
```bash
java -jar target/mcp-server-0.0.1-SNAPSHOT.jar
```

The server will start on port **8081** by default (configurable in `src/main/resources/application.yaml`).

## API Endpoints

### REST API

#### Get Current Time
- **Endpoint:** `GET /v1/time/current-time`
- **Description:** Returns the current time, time zone, format, and milliseconds since epoch.
- **Example Request:**
  ```bash
  curl http://localhost:8081/v1/time/current-time
  ```

- **Response Example:**
  ```json
  {
    "currentTime": "2026-02-03 12:34:56",
    "timeZone": "America/New_York",
    "format": "yyyy-MM-dd HH:mm:ss",
    "currentTimeMillis": 1738596896000
  }
  ```

### MCP Server

The MCP server is enabled and configured via Spring AI. The application exposes MCP tools that can be consumed by MCP clients.

#### Available MCP Tools

- **`fetch_current_time`**: Fetches the current time details including formatted time, timezone, and milliseconds since epoch.

For more information on MCP protocol and integration, see the [Spring AI MCP Server Documentation](https://docs.spring.io/spring-ai/reference/api/mcp/mcp-server-boot-starter-docs.html).

## Configuration

Key configuration settings in `src/main/resources/application.yaml`:

```yaml
spring:
  ai:
    mcp:
      server:
        name: mcp-server
        version: 1.0.0
        type: sync
        protocol: streamable
        enabled: true

server:
  port: 8081
```

## Project Structure

```
mcp-server/
├── src/
│   ├── main/
│   │   ├── java/com/navneet/mcp_server/
│   │   │   ├── McpServerApplication.java         # Main Spring Boot application
│   │   │   ├── controller/
│   │   │   │   └── TimeController.java           # REST controller for time API
│   │   │   ├── models/
│   │   │   │   └── TimeUtilResponse.java         # Model for time API response
│   │   │   └── service/
│   │   │       ├── TimeUtilService.java          # Service interface
│   │   │       └── impl/
│   │   │           └── TimeUtilServiceImpl.java  # Service implementation with @McpTool
│   │   └── resources/
│   │       └── application.yaml                  # Application configuration
│   └── test/
│       └── java/com/navneet/mcp_server/
│           └── McpServerApplicationTests.java    # Spring Boot tests
├── pom.xml                                       # Maven build configuration
├── LICENSE                                       # GNU GPL v3 License
└── README.md                                     # Project documentation
```

## Development

### Running Tests
```bash
./mvnw test
```

### Building without tests
```bash
./mvnw clean install -DskipTests
```

### Creating executable JAR
```bash
./mvnw clean package
```

## Technologies Used

- **Spring Boot 3.5.10** - Application framework
- **Spring AI 1.1.2** - MCP server implementation
- **Spring Web** - RESTful API
- **Lombok** - Reduce boilerplate code
- **JUnit 5** - Testing framework
- **Java 21** - Programming language
- **Maven** - Build and dependency management

## Contribution Guidelines

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/your-feature`)
3. Commit your changes (`git commit -m 'Add some feature'`)
4. Push to the branch (`git push origin feature/your-feature`)
5. Open a Pull Request

### Coding Standards
- Follow standard Java and Spring Boot best practices
- Write clear and descriptive commit messages
- Add or update tests as appropriate
- Maintain code documentation and comments

## License

This project is licensed under the [GNU General Public License v3.0](LICENSE).

## Contact & Support

For questions, issues, or feature requests, please open an issue on the repository.

**Author:** Navneet Prabhakar

## Acknowledgments

- [Spring AI](https://spring.io/projects/spring-ai) - For MCP server support
- [Model Context Protocol](https://modelcontextprotocol.io/) - For the MCP specification
