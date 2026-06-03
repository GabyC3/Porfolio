import { useEffect, useState } from "react";
import { getHerramientas } from "../services/api";

export default function Skills() {
  const [skills, setSkills] = useState([]);

  useEffect(() => {
    getHerramientas().then(res => setSkills(res.data));
  }, []);

  return (
    <section id="skills">
      <h2>Tecnologías</h2>
      {skills.map(s => (
        <div key={s.id}>{s.nombre}</div>
      ))}
    </section>
  );
}