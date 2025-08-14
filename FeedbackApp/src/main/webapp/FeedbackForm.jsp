<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Feedback Form</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background: linear-gradient(to right, #eef2f3, #dfe6e9);
            padding-top: 50px;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }
        .feedback-container {
            max-width: 700px;
            margin: auto;
            background: #fff;
            padding: 30px 40px;
            border-radius: 12px;
            box-shadow: 0 8px 25px rgba(0,0,0,0.1);
        }
        h2 {
            text-align: center;
            margin-bottom: 25px;
            font-weight: 600;
            color: #2d3436;
        }
        .form-label {
            font-weight: 500;
        }
        .btn-submit {
            width: 100%;
            padding: 12px;
            font-size: 1.1rem;
            border-radius: 8px;
            transition: all 0.3s ease-in-out;
        }
        .btn-submit:hover {
            transform: scale(1.02);
            background-color: #0d6efd;
            box-shadow: 0 4px 12px rgba(13, 110, 253, 0.3);
        }
    </style>
</head>
<body>
    <div class="feedback-container">
        <h2>Feedback App</h2>
        <form action="FeedbackController" method="post" class="needs-validation" >
            
            <div class="mb-3">
                <label class="form-label">Name</label>
                <input type="text" name="name" class="form-control" required>
            </div>

            <div class="mb-4"> 
                <label class="form-label">Session Date</label>
                <input type="date" name="sessionDate" class="form-control" required>
            </div>

            <div class="row g-3">
                <div class="col-md-6">
                    <label class="form-label">Session Content</label>
                    <input type="number" name="sessionContent" min="1" max="10" class="form-control" required>
                </div>
                <div class="col-md-6">
                    <label class="form-label">Query Resolution</label>
                    <input type="number" name="queryResolution" min="1" max="10" class="form-control" required>
                </div>
                <div class="col-md-6">
                    <label class="form-label">Interactivity</label>
                    <input type="number" name="interactivity" min="1" max="10" class="form-control" required>
                </div>
                <div class="col-md-6">
                    <label class="form-label">Impactful Learning</label>
                    <input type="number" name="impactfulLearning" min="1" max="10" class="form-control" required>
                </div>
                <div class="col-md-6">
                    <label class="form-label">Content Delivery Skills</label>
                    <input type="number" name="contentDelivery" min="1" max="10" class="form-control" required>
                </div>
            </div>

            <div class="mt-4">
                <button type="submit" class="btn btn-primary btn-submit">Submit Feedback</button>
            </div>
        </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
