# Aamya Health

Aamya Health is a modern Android application built using **Jetpack Compose** with a **Clean Architecture** pattern.  
It offers a sleek and intuitive UI to manage health‑related tasks and features.

---

## 🎯 Features

- UI built entirely with **Jetpack Compose**  
- Clean Architecture: separation of presentation, domain, and data layers  
- Sample screens: login, dashboard, profile, etc.  
- Local persistence + networking (as needed)  
- Responsive layout, state management, theming, etc.

---

## 🖼️ Screenshots & Demo

<p align="center">
  <img src="https://github.com/user-attachments/assets/e175700d-64d0-4cb7-9638-0f9dbf01f121" alt="Screenshot1" width="250"/>
  <img src="https://github.com/user-attachments/assets/5aafaf81-ebd0-442d-8060-6195230cef8f" alt="Screenshot2" width="250"/>
</p>

You can view the demo video here:  
[Demo Video](https://github.com/user-attachments/assets/4553d638-6a14-4309-9c3c-f2fe2a3a8952)
---

## 🧩 Architecture & Tech Stack

- **Jetpack Compose** for UI  
- **Kotlin**  
- **Clean Architecture** (Presentation / Domain / Data)  
- (Optional) Retrofit / Room / Coroutines / Flow / etc.  

---

## 📂 Project Structure (suggested)

```
app/
 ├─ src/
 │   ├─ main/
 │   │   ├─ ui/                — Compose UI components (screens, theming, navigation)
 │   │   ├─ data/              — Repositories, remote/local data sources, models
 │   │   ├─ domain/            — Use cases, business logic, domain models
 │   │   └─ util/              — Utilities, helpers, common code
 ├─ build.gradle(.kts)
 └─ settings.gradle(.kts)
```

You can adapt this as per your actual project layout.

---

## 🚀 How to Run / Setup

1. Clone the repo  
   ```bash
   git clone https://github.com/rahulyas/Aamya-health.git
   ```
2. Open in Android Studio  
3. Sync Gradle  
4. Run on an emulator or real device (minimum SDK, permissions, etc.)  

---

## 📦 Dependencies

Here are some typical libraries you might be using:

- androidx.compose: compose UI, Material  
- androidx.lifecycle: ViewModel, LiveData / StateFlow  
- kotlinx.coroutines, Flow
- 
---
## 🤝 Contributing

Contributions are welcome! Feel free to open issues or pull requests.
