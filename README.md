# Fitnes aplikacija

Emina Kaknjo, Amina Bojić

## Opis projekta
Fitness aplikacija omogućava pregled i upravljanje trenerima i njihovim vježbama.  
Glavne funkcionalnosti:
- Lista svih trenera i detalji o svakom treneru
- Pregled svih vježbi i dodavanje novih
- Dodavanje postojećih vježbi treneru
- Lista svih klijenata (novi model), dodavanje novih, uređivanje i brisanje psotojećih

### Modeli
1. **Trainer**
    - `id` – jedinstveni identifikator
    - `name` – ime trenera
    - `specialty` – specijalnost trenera
    - `experienceYears` – godine iskustva
    - `exercises` – lista vježbi koje trener vodi

2. **Exercise**
    - `id` – jedinstveni identifikator
    - `name` – naziv vježbe
    - `muscleGroup` – ciljna mišićna grupa
    - `durationMinutes` – trajanje vježbe u minutama
    - `difficulty` – težina vježbe
- Relacija **Exercise-Trainer (Many-to-many)**: Jedan trener (`Trainer`) može imati više vježbi (`Exercise`) i obratno. Veza je prikazana u view-u na stranici detalja trenera (`trainer-details.html`)

3. **Client-NOVI MODEL**
   - `id` – jedinstveni identifikator
   - `name` – ime klijenta
   - `age` – godine
   - `goal` – cilj treninga
   - `trainer` – trener

### Opis logike dodavanja novog modela i ostvarene relacije

### Nove relacije
- **Client-Trainer (Many-to-one)**: (jedan trener može imati više klijenata a jedan klijent samo jednog trenera)


### Client Controller funkcionalnosti
Ovaj kontroler omogućava rad s modelom Client putem Thymeleaf prikaza i standardnih web formi:

- GET /clients – prikazuje listu svih klijenata i formu za dodavanje novog klijenta (clients.html).
- POST /clients/save – sprema novog klijenta, povezujući ga s trenerom po odabranom trainerId.
- GET /clients/edit/{id} – prikazuje formu za uređivanje postojećeg klijenta (clients.html).
- POST /clients/update/{id} – ažurira podatke postojećeg klijenta i njegovog trenera.
- GET /clients/delete/{id} – briše klijenta po ID-u.

### RestController
Ovaj kontroler omogućava rad s modelom Client putem REST API-ja, vraćajući JSON podatke:

- GET /api/clients – vraća listu svih klijenata.
- GET /api/clients/{id} – vraća jednog klijenta po ID-u.
- POST /api/clients – dodaje novog klijenta (prima JSON objekt).
- PUT /api/clients/{id} – ažurira postojećeg klijenta po ID-u (prima JSON objekt).
- DELETE /api/clients/{id} – briše klijenta po ID-u

### Konfiguracija baze
Ovaj projekat koristi MySQL bazu podataka za pohranu podataka o trenerima, klijentima i vježbama.
U application.properties konfigurisan je pristup MySQL bazi.
Projekt koristi JPA entitete za kreiranje tablica:
- Trainer – tablica trainer
- Client – tablica client (relacija Many-to-One prema Trainer)
- Exercise – tablica exercise (relacija Many-to-many prema Trainer)

## HTML stranice
- `trainers.html` – lista trenera i dodavanje novog trenera
- `trainer-details.html` – detalji jednog trenera, dodavanje postojećih vježbi
- `exercises.html` – lista vježbi i dodavanje novih
- `clients.html` - list svih klijenata, dodavanje novih, uređivanje i brisanje postojećih

## Screenshot aplikacije

### Lista trenera
![Trainers](src/main/resources/static/images/treneri_lab2.png)

### Detalji trenera
![Trainer Details 1](src/main/resources/static/images/detalji_lab2.png)

### Lista vježbi
![Exercises](src/main/resources/static/images/vjezbe_lab2.png)

### Lista klijenata
![Clients](src/main/resources/static/images/klijenti_lab2.png)

## Tehnologije
- Java 17
- Spring Boot 3.x
- Thymeleaf
- Maven  

## Uputstvo za pokretanje

1. **Kloniraj repozitorij**:
git clone https://github.com/Emina-1/fitnes-ap.git
2. Otvori projekat u IntelliJ IDEA ili drugom IDE-u koji podržava Spring Boot.
3. Pokreni Maven build
4. Iz IDE-a pokreni glavnu klasu FitnessApplication.java
5. Pristup aplikaciji putem http://localhost:8080

