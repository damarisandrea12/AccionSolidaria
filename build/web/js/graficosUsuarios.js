/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
const ctx = document.getElementById('myChart');

new Chart(ctx, {
    type: 'bar',
    data: {
        labels: ['Administradores', 'Instituciones'],
        datasets: [{
                label: '# USUARIOS',
                data: [document.getElementById('admi').value , document.getElementById('insti').value],
                backgroundColor: ['rgba(40, 242, 181  )', 'rgba(211, 242, 40)'],
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

