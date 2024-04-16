// Dữ liệu mẫu cho biểu đồ
var salesData = {
    labels: ['Tháng 1', 'Tháng 2', 'Tháng 3', 'Tháng 4', 'Tháng 5'],
    datasets: [{
            label: 'Doanh số bán hàng',
            data: [100, 200, 150, 250, 300],
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)'
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)'
            ],
            borderWidth: 1
        }]
};

// Vẽ biểu đồ bán hàng
var ctx = document.getElementById('salesChart').getContext('2d');
var salesChart = new Chart(ctx, {
    type: 'bar',
    data: salesData,
    options: {
        scales: {
            yAxes: [{
                    ticks: {
                        beginAtZero: true
                    }
                }]
        }
    }
});

// Mã JavaScript để cập nhật số lượng lượt xem
setInterval(function () {
    // Mã giả để cập nhật số lượng lượt xem (có thể thay thế bằng mã thực tế)
    var viewCount = parseInt(document.getElementById('viewCount').innerText);
    document.getElementById('viewCount').innerText = viewCount + 1;
}, 1000); // Cập nhật số lượng lượt xem mỗi giây