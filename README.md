A Java REST API to control a home automation system. The Spring API provides the ability to add, edit, delete rooms, equipment, and controls, and get/set the values of the controls.

# Steps

- Create a Spring Data REST project to serve the HATEOAS compliant API. Use the Spring Boot Gradle plugin for dependencies
- Build entities and relationships between Room, Device, Control, and User based on the diagram
- Build repositories that can be paged and sorted for each of the entities
- Expose the API under /api/v1/
- Secure the API so that only authenticated users can view details
- Ensure that the users repository is not exported
- Secure the API so that only users with the ROLE\_ADMIN role can create rooms
- Validate that room&#39;s area is less than 1000 (sq ft/sq meters) and ensure friendly JSON messages are returned to the caller
- Create documentation that is exposed in Hypermedia Application Language (HAL) for the Room.area field for fellow developers who will use your API that explain that the value should represent either square meters or square footage depending on your units of measure.
- Add a search resource that provides the ability to find Devices based on a partial name.
- Track the last user to modify the control and report it in control.lastModifiedBy
- Ensure that control modifications are versioned so that clients can use appropriate E-Tags
- Add additional searches to find rooms by name and less than a specified area
