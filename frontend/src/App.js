import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './App.css';

function App() {
  const [departments] = useState(['IKT', 'TECH', 'BUSINESS']);
  const [counters, setCounters] = useState({});

  const fetchCounters = async () => {
    const newCounters = {};
    for (const dept of departments) {
      try {
        const response = await axios.get(`/api/clicks/${dept}`);
        newCounters[dept] = response.data.countValue || 0;
      } catch (error) {
        console.error(`Error fetching ${dept}:`, error);
        newCounters[dept] = 0;
      }
    }
    setCounters(newCounters);
  };

  const incrementCounter = async (department) => {
    try {
      const response = await axios.post(`/api/clicks/increment/${department}`);
      setCounters(prev => ({
        ...prev,
        [department]: response.data.countValue
      }));
    } catch (error) {
      console.error(`Error incrementing ${department}:`, error);
    }
  };

  useEffect(() => {
    fetchCounters();
    const interval = setInterval(fetchCounters, 5000);
    return () => clearInterval(interval);
  }, [departments]);

  return (
    <div className="App">
      <header className="App-header">
        <h1>VIA Tabloid Application</h1>
        <p>Sensational Story Counter by Department</p>
      </header>
      
      <main className="App-main">
        {departments.map(dept => (
          <div key={dept} className="department-card">
            <h2>{dept} Department</h2>
            <p>Sensational Stories: {counters[dept] || 0}</p>
            <button 
              onClick={() => incrementCounter(dept)}
              className="click-button"
            >
              Add Story to {dept}
            </button>
          </div>
        ))}
      </main>
    </div>
  );
}

export default App;