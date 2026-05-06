# Smart Campus Event Management System

## Run in Eclipse
1. Extract the ZIP.
2. Eclipse: File > Import > Maven > Existing Maven Projects.
3. Select the extracted `smart-campus-event-system` folder.
4. Right click project > Maven > Update Project.
5. Open `SmartCampusEventSystemApplication.java`.
6. Run As > Spring Boot App.
7. Open: http://localhost:8080

## Login
Admin:
- Email: admin@campus.com
- Password: admin123

Student:
- Register a new account.
- OTP appears in console by default because `app.mail.enabled=false`.
- For real Gmail OTP, add Gmail App Password in `application.properties` and set `app.mail.enabled=true`.

## Fixed / Added
- Events are now seeded automatically when DB is empty.
- Student dashboard shows available events even after login.
- Event registration now asks personal details: full name, email, phone, roll number, department, year, attendees, requirements.
- PDF ticket includes personal registration details.
- Premium vintage gradient UI added.
