import i18n from "i18next";
import { initReactI18next } from "react-i18next";

i18n.use(initReactI18next).init({
  resources: {
    es: {
      translation: {
       about: {
              title: "Sobre mí",
              tech: "Tecnologías",
              descripcion1: "Soy desarrollador de software con más de 2 años de experiencia en el diseño y desarrollo de aplicaciones web y APIs. Trabajo principalmente con C#, creando soluciones modernas, eficientes y escalables, enfocadas en la calidad y una buena experiencia de usuario. Me destaco por mi capacidad de análisis y razonamiento crítico para resolver problemas y optimizar procesos, desarrollando sistemas funcionales y agradables en su uso."
              ,descripcion2: "Actualmente busco incorporarme a un equipo donde pueda seguir creciendo profesionalmente, aportar valor y continuar ampliando mis conocimientos."
       },
       nav: {
               inicio: "Inicio",
               about: "Sobre mí",
               proyectos: "Proyectos",
               contacto: "Contacto"
       },
       hero: {
                     saludo: "Hola! Soy",
                     profesion: "Desarrollador de Software",
                     descripcion: "Soy desarrollador dedicado a la construcción de aplicaciones web modernas. Me enfoco en crear soluciones eficientes, escalables y con buen diseño.",
                     contacto: "Contáctame",
                     cv: "CV"
       },
       projects: {
             title: "Proyectos"
       },
       contact: {
         title: "Contacto",
         texto: "¿Tenés una idea, proyecto o simplemente querés conectar? Estoy abierto a nuevas oportunidades, colaboraciones o charlas interesantes. No dudes en escribirme, te voy a responder lo antes posible 🚀",
         boton: "Contáctame",
         subject: "Consulta desde portfolio",
         body: "Hola Gabriel, vi tu portfolio y me gustaría contactarte para conversar sobre una oportunidad o proyecto. Quedo atento a tu respuesta."
       }
      }
    },
    en: {
      translation: {
      about: {
              title: "About me",
              tech: "Technologies",
              descripcion1: "I am a software developer with over two years of experience in the design and development of web applications and APIs. I work with C#, creating modern, efficient, and scalable solutions focused on quality and a good user experience. I excel at analytical and critical thinking skills for solving problems and optimizing processes, developing functional and user-friendly systems."
              ,descripcion2: "I am currently looking to join a team where I can continue to grow professionally, add value, and further expand my knowledge."
      },
      nav: {
              inicio: "Home",
              about: "About me",
              proyectos: "Projects",
              contacto: "Contact"
      },
      hero: {
                    saludo: "Hi! I'm",
                    profesion: "Software Developer",
                    descripcion: "I am a developer focused on building modern web applications. I create efficient, scalable solutions with great design.",
                    contacto: "Contact me",
                    cv: "Resume"
      },
      projects: {
            title: "Projects"
      },
      contact: {
        title: "Contact",
        texto: "Do you have an idea, project, or just want to connect? I'm open to new opportunities, collaborations, or interesting conversations. Feel free to reach out, I'll reply as soon as possible 🚀",
        boton: "Contact me",
        subject: "Portfolio inquiry",
        body: "Hi Gabriel, I came across your portfolio and would like to get in touch to discuss a potential opportunity or project. Looking forward to your reply."
      }
     }
    }
  },
  lng: "es", // idioma inicial
  fallbackLng: "es",
  interpolation: {
    escapeValue: false
  }
});

export default i18n;