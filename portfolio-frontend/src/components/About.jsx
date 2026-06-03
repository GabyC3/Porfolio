import { useEffect, useState } from "react";
import { motion } from "framer-motion";
import axios from "axios";
import { useTranslation } from "react-i18next";

function About() {
  const [herramientas, setHerramientas] = useState([]);
  const { t } = useTranslation();

  useEffect(() => {
    axios.get("http://localhost:8081/api/herramientas")
      .then(res => setHerramientas(res.data))
      .catch(err => console.error(err));
  }, []);

  return (
    <section id="about" className="about">

      <div className="about-container">

        {/* IZQUIERDA */}
        <motion.div className="about-text"
            initial={{ opacity: 0, x: -50 }}
            whileInView={{ opacity: 1, x: 0 }}
            transition={{ duration: 0.8 }} >
          <motion.h2
                  className="efecto-titulo"
                  initial={{ opacity: 0, y: 20 }}
                  whileInView={{ opacity: 1, y: 0 }}
                  viewport={{ once: true }}
                >
                   {t("about.title")}

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
            <p>{t("about.descripcion1")}</p>
            <p>{t("about.descripcion2")}</p>
        </motion.div>

        {/* DERECHA */}
        <motion.div className="about-tech"
            initial={{ opacity: 0, x: 50 }}
            whileInView={{ opacity: 1, x: 0 }}
            transition={{ duration: 0.8 }} >
          <motion.h3
                  className="efecto-titulo"
                  initial={{ opacity: 0, y: 20 }}
                  whileInView={{ opacity: 1, y: 0 }}
                  viewport={{ once: true }}
                >
                  {t("about.tech")}

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
          </motion.h3>

          <div className="tech-grid">
                      {herramientas.map((h, i) => (
                        <motion.div
                          key={h.id}
                          className="tech-card"
                          initial={{ opacity: 0, y: 30 }}
                          whileInView={{ opacity: 1, y: 0 }}
                          transition={{ delay: i * 0.1 }}
                          whileHover={{ scale: 1.08 }}
                        >
                          <img src={h.icono} alt={h.nombre} />

                          {/* TOOLTIP */}
                          <span className="tooltip">{h.nombre}</span>
                        </motion.div>
                      ))}
                    </div>
        </motion.div>

    </div>

    </section>
  );
}

export default About;