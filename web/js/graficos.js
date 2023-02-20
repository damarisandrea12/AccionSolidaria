/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
const ctx = document.getElementById('myChart');

new Chart(ctx, {
    type: 'doughnut',
    data: {
        labels: ['Activas', 'Canceladas', 'Exitosas'],
        datasets: [{
                label: '# DONACIONES',
                data: [document.getElementById('activa').value , document.getElementById('cancelada').value, document.getElementById('exitosa').value],
                backgroundColor: ['rgba(40, 242, 193 )', 'rgba(242, 77, 40)', 'rgba(132, 242, 40)'],
                borderWidth: 1
            }]
    },
    options: {
        scales: {
            y: {
                beginAtZero: true
            }
        }
    }
});
const ctx2 = document.getElementById('myChart2');

new Chart(ctx2, {
    type: 'bar',
    data: {
        labels: ['Instituciones', 'Administradores'],
        datasets: [{
                label: '# USUARIOS',
                data: [document.getElementById('insti').value , document.getElementById('admi').value],
                backgroundColor: ['rgba(40, 242, 193 )', 'rgba(242, 77, 40)'],
                borderWidth: 1
            }]
    },
    options: {
        scales: {
            y: {
                beginAtZero: true
            }
        }
    }
});

