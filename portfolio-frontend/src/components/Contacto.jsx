import { FaEnvelope } from "react-icons/fa";
import { motion} from "framer-motion";
import { DotLottieReact } from '@lottiefiles/dotlottie-react';
import { useTranslation } from "react-i18next";

function Contacto() {
    const { t, i18n } = useTranslation();
    const mailto = `mailto:gabyrc69@gmail.com?subject=${encodeURIComponent(t("contact.subject"))}&body=${t("contact.body")}`;

  return (
    <section id="contacto" className="contacto">
      <motion.h2
              className="efecto-titulo"
              initial={{ opacity: 0, y: 20 }}
              whileInView={{ opacity: 1, y: 0 }}
              viewport={{ once: true }}
            >
            {t("contact.title")}

              <motion.span
                className="linea"
                initial={{ width: 0 }}
                whileInView={{ width: "60%" }}
                transition={{
                  type: "spring",
                  stiffness: 120,
                  damping: 20
                }}
              />
      </motion.h2>

    <div className="contacto-elementos">
       <div className="contacto-info">
                <p className="contacto-texto">
                    {t("contact.texto")}
                </p>

                <a href={mailto} target="_blank" rel="noreferrer" className="btn-pro">
                    <FaEnvelope className="icon" />
                    <span>{t("contact.boton")}</span>
                </a>
       </div>
      <div className="contacto-animacion">
                <DotLottieReact
                  src="https://lottie.host/52b6ba8e-a00e-4830-8b52-6ebc0bf70985/uTDrBLVM2p.json"
                  loop
                  autoplay
                />
      </div>
    </div>
    </section>
  );
}

export default Contacto;