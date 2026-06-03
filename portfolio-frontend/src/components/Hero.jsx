//import { FaReact } from "react-icons/fa";
import { motion } from "framer-motion";
import "../download.svg";
import Animacion from "../components/Animacion";
import { useTranslation } from "react-i18next";

function Hero() {
    const scrollToContacto = () => {
        document.getElementById("contacto").scrollIntoView({
          behavior: "smooth"
        });
      };
  const { t } = useTranslation();

  return (
    <section id="hero" className="hero">

        <div className="hero-content">
        <div className="hero-text">
            <br />
            <br />
            <motion.p
                    initial={{ opacity: 0 }}
                    animate={{ opacity: 1 }}
                    >
                    {t("hero.saludo")}
            </motion.p>

            <motion.h1
                initial={{ opacity: 0, y: 40 }}
                animate={{ opacity: 1, y: 0 }}
            >
            Gabriel Condori <br />
            </motion.h1>

            <motion.h2
                 initial={{ opacity: 0, y: 40 }}
                 animate={{ opacity: 1, y: 0 }}
            >
            {t("hero.profesion")}
            </motion.h2>
            <br />
            <motion.p
                initial={{ opacity: 0 }}
                animate={{ opacity: 1 }}
                transition={{ delay: 0.5 }}
            >
            {t("hero.descripcion")}

            </motion.p>

            <div className="hero-buttons">

                        <a href="/Gabriel_Condori.pdf" className="btn primary" target="_blank" rel="noopener noreferrer">
                         <svg
                           viewBox="0 0 25 25"
                           fill="none"
                           stroke="currentColor"
                           strokeWidth="2"
                         >
                           <path d="M12 5v14M5 12l7 7 7-7" />
                         </svg>
                          <span>{t("hero.cv")}</span>
                        </a>


                        <button onClick={scrollToContacto} className="btn secondary">
                          {t("hero.contacto")}
                        </button>

            </div>
        </div>
        <div className="animation">
                      <Animacion />
        </div>
    </div>
    </section>
  );
}

export default Hero;