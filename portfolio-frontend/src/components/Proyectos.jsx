import { useEffect, useState } from "react";
import { getProyectos, getHerramientasPorProyecto } from "../services/api";
import { motion, AnimatePresence } from "framer-motion";
import { useTranslation } from "react-i18next";


export default function Proyectos() {
  const [proyectos, setProyectos] = useState([]);
  const [selectedImg, setSelectedImg] = useState(null);
  const { t } = useTranslation();

  useEffect(() => {
    getProyectos().then(async (res) => {
      const data = await Promise.all(
        res.data.map(async (p) => {
          const herramientas = await getHerramientasPorProyecto(p.id);
          return { ...p, herramientas: herramientas.data };
        })
      );
      setProyectos(data);
    });
  }, []);

  return (
    <section id="proyectos" className="projects">
      <motion.h2
        className="efecto-titulo"
        initial={{ opacity: 0, y: 20 }}
        whileInView={{ opacity: 1, y: 0 }}
        viewport={{ once: true }}
      >
        {t("projects.title")}

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

      <div className="projects-container">
        {proyectos.map((p, i) => (
          <motion.div
            key={p.id}
            className="project-card"
            initial={{ opacity: 0, y: 40 }}
            whileInView={{ opacity: 1, y: 0 }}
            transition={{ delay: i * 0.2 }}
          >
            {/* IMAGEN */}
          <div className="project-image">
            <motion.img
              src={p.imagen || "https://picsum.photos/400/250"}
              alt={p.titulo}
              className="clickable-img"
              layoutId={`img-${p.id}`}
              onClick={() => setSelectedImg(p)}
              whileHover={{ scale: 1.05 }}
            />
          </div>

            {/* CONTENIDO */}
            <div className="project-info">
              <h3>{p.titulo}</h3>

              {/* TECNOLOGÍAS */}
              <div className="tech-row">
                {p.herramientas?.map(h => (
                  <div key={h.id} className="tech-chip">
                    <img src={h.icono} alt={h.nombre} />
                    <span>{h.nombre}</span>
                  </div>
                ))}
              </div>

              <p>{p.descripcion}</p>

              {/* BOTONES */}
              <div className="project-buttons">

                <a href={p.enlace} target="_blank" rel="noreferrer" className="btn primary">
                  <img src="https://api.iconify.design/akar-icons:github-fill.svg" alt="github" />
                  <span>Github</span>
                </a>
              </div>
            </div>
          </motion.div>
        ))}
      </div>
      <AnimatePresence>
         {selectedImg && (
         <motion.div
         className="modal"
         onClick={() => setSelectedImg(null)}
         initial={{ opacity: 0 }}
         animate={{ opacity: 1 }}
         exit={{ opacity: 0 }}
         >
         <motion.img
         src={selectedImg.imagen}
         className="modal-img"
         layoutId={`img-${selectedImg.id}`}
         onClick={(e) => e.stopPropagation()}
         transition={{ type: "spring", stiffness: 120, damping: 20 }}

         />
         </motion.div>
         )}
      </AnimatePresence>

    </section>

  );
}