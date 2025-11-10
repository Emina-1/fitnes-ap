# Fitnes aplikacija

Emina Kaknjo, Amina Bojić

## Opis projekta
Fitness aplikacija omogućava pregled i upravljanje trenerima i njihovim vježbama.  
Glavne funkcionalnosti:
- Lista svih trenera i detalji o svakom treneru
- Pregled svih vježbi i dodavanje novih
- Dodavanje postojećih vježbi treneru
- Lista svih klijenata (novi model)

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

3. **Client**
   - `id` – jedinstveni identifikator
   - `name` – ime klijenta
   - `age` – godine
   - `goal` – cilj
   - `trainer` – trener

### Relacija
- **1:N**: Jedan trener (`Trainer`) može imati više vježbi (`Exercise`)
- Veza je prikazana u view-u na stranici detalja trenera (`trainer-details.html`)
-Veza 1:N između trenera i klijenata (jedan trener može imati više klijenata a jedan klijent samo jednog trenera)

## Kontroleri i GET rute
MVC rute (Thymeleaf)
-/trainers – prikaz liste svih trenera (trainers.html).

-/trainers/{id} – detalji jednog trenera i forma za dodavanje vježbi (trainer-details.html).

-/exercises – prikaz liste svih vježbi i forma za dodavanje novih (exercises.html).

-/clients – prikaz liste svih klijenata i forma za dodavanje/uređivanje (clients.html).

-/clients/new – prikaz forme za dodavanje novog klijenta (Thymeleaf forma unutar clients.html).

-/ – početna ruta koja preusmjerava na /trainers.

REST API rute (JSON)

-GET /api/trainers – vraća listu svih trenera u JSON formatu.

-GET /api/trainers/{id} – vraća jednog trenera po ID-u u JSON formatu.

-POST /api/trainers – dodaje novog trenera (prima JSON objekt).

-PUT /api/trainers/{id} – ažurira postojećeg trenera po ID-u (prima JSON objekt).

-DELETE /api/trainers/{id} – briše trenera po ID-u.

-POST /api/trainers/{trainerId}/exercises/{exerciseId} – dodaje postojeću vježbu treneru po ID-u.

-GET /api/clients – vraća listu svih klijenata u JSON formatu.

-GET /api/clients/{id} – vraća jednog klijenta po ID-u u JSON formatu.

-POST /api/clients – dodaje novog klijenta (prima JSON objekt).

-PUT /api/clients/{id} – ažurira postojećeg klijenta po ID-u (prima JSON objekt).

-DELETE /api/clients/{id} – briše klijenta po ID-u.

## HTML stranice
- `trainers.html` – lista trenera
- `trainer-details.html` – detalji jednog trenera + dodavanje postojećih vježbi
- `exercises.html` – lista vježbi i dodavanje novih
- `clients.html` - list svih klijenata, dodavanje novih, uređivanje i brisanje postojećih

## Screenshot aplikacije

### Lista trenera
![Trainers](src/main/resources/static/images/trainers.png)

### Detalji trenera - prikaz 1
![Trainer Details 1](src/main/resources/static/images/trainer-details1.png)

### Detalji trenera - prikaz 2
![Trainer Details 2](src/main/resources/static/images/trainer-details2.png)

### Lista vježbi
![Exercises](src/main/resources/static/images/exercises.png)

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

