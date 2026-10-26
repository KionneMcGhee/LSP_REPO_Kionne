# Question 2 — CRC Cards

Class: Student
Responsibilities: Encapsulate student ID, name and contact information.
Collaborators: Registration

Class: Course
Responsibilities: Encapsulate course code and credit hours.
Collaborators: Registration

Class: Registration
Responsibilities: Associate student and course data; represent registration and calculated tuition.
Collaborators: Student, Course

Class: TuitionCalculator
Responsibilities: Apply per-credit pricing and discount rules.
Collaborators: Registration, Course

Class: RegistrationService
Responsibilities: Coordinate registration, tuition calculation, storage, confirmation and error handling.
Collaborators: Registration, TuitionCalculator, RegistrationRepository, ConfirmationSender, RegistrationLogger

Class: RegistrationRepository (interface)
Responsibilities: Abstract saving registrations.
Collaborators: Registration

Class: FileRegistrationRepository
Responsibilities: Save registrations to a local file.
Collaborators: RegistrationRepository, Registration

Class: ConfirmationSender (interface)
Responsibilities: Abstract sending confirmations.
Collaborators: Registration

Class: EmailConfirmationSender
Responsibilities: Send confirmations via email.
Collaborators: ConfirmationSender, Registration, Student

Class: RegistrationLogger
Responsibilities: Record registration events with timestamps.
Collaborators: RegistrationService