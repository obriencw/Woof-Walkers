# Woof Walkers
## Overview
Woof Walkers is an application that gives dog owners the ability to schedule an appointment to have their dog walked whenever they need it.

- [Daily Progress](#Daily-Progress)
- [User Stories](#User-Stories)
  - [User](#User)
  - [Admin](#Admin)
- [Wireframe](#Wireframe)
- [Technical Architecture](#Technical-Architecture)
- [Technical Challenges](#Technical-Challenges)
- [For the Future](#For-the-Future)


## Daily Progress
**April 20 (82%)**
* Custom queries working as expected

**ToDo**
* Add testing
* Fix CRUD to delete dog and delete appointment to avoid foreign key constraint error
* Fix CRUD for updating a user

*April 19 (82%)
* Added custom queries (not complete)

*April 18 (75-80%)
  * Added navbar for in-app navigation
  * Added feature that when a user schedules a walk that appointment is registered to the current user
  * Added profile page that displays the user's dogs and scheduled appointments
  * Updated user stories
  * Updated wireframe
  * Updated security for which pages can be accessed by different roles
  * Added ability to grant admin and superadmin privileges.
  * Added additional fields to user registration.
  
  * April 15 (60% done)
    * Added feature that when a user registers a dog, that dog is registered to the current user who is logged in
  * April 14 (55% done)
    * Completed CRUD operations for Appointment
    * All basic CRUD operations completed
    * Started implementing user registration
  * April 13 (35% done)
    * Updated CRUD operations for Appointment but unable to save date and time
  * April 12 (25-30% done)
    * Added Dog model, DogRepository, DogService, and DogServiceImpl
    * Implemented CRUD operations for Dog
    * Created corresponding HTML pages for Dog CRUD
    * Added Appointment model, AppointmentRepository, AppointmentService and AppointmentServiceImpl
    * Implemented CRUD operations for Appointments
    * Created corresponding HTML pages for Appointment CRUD
    * All tables linked with foreign keys
  * April 11 (20% done)
Today I changed my project from a social media app to a scheduling app that allows users to schedule an appointment to have their dog walked.

## User Stories

### User
* As a user, I want to have a customized profile so that my profile is unique to me.
  * As a user, I want my profile to display my dog's information so that I can view my dog's information.
  * As a user, I want my profile to display the walks that I have scheduled so that I can keep track of my appointments.
* As a user, I want to schedule multiple appointments so that I can have my dog walked on different days.
* As a user, I want to register multiple dogs so that I don't have to create a new profile for each of my dogs.
* As a user, I want to schedule an appointment for multiple dogs so that I can have both of my dogs walked at the same time.

### Admin
* As an admin, I want to be able to control appointments so that I can adapt to various changes.
  * As an admin, I want to be able to update scheduled appointments so that if a user has a schedule conflict I can adapt.
  * As an admin, I want to be able to delete appointments so that if a user no longer needs an appointment I can remove it.
* As an admin, I want to update user information so that if a user's information changes I can adapt.
* As an admin, I want to delete user information so that users can be removed if needed.

## Wireframe
* https://www.figma.com/file/0aUQZvliXKJ65VpRpjj9mf/Woof-Walkers?node-id=0%3A1

## Technical Architecture
* Users are able to register a profile, add their dog(s) to their profile and schedule an appointment to have their dog(s) walked.
* Admins are able to update and delete user information, and appointment information.

## Technical Challenges
* The original idea for my project was to create a social media app for dogs, but I had difficulty implementing a lot of my ideas.  I decided to change my project to a scheduling app where users can request an appointment to have their dog walked.  This change allowed me to implement more of the features that were covered during the instruction of the course.

## For the Future
* Add functionality to be able to have multiple dog walkers and allow users to choose their dog walker.
* Automate scheduling so that appointment scheduling does not overlap.
* Add google maps API and java logic to determine if the user is within a maximum distance of an available 'walker'