function LoadingPage() {
  return (
    <div className="loading-page" role="status" aria-live="polite">
      <div className="loading-content">
        <div className="loading-logo">
          <span className="loading-logo-text">User Management</span>
        </div>

        <div className="loading-spinner">
          <div className="loading-spinner-ring"></div>
        </div>

        <p className="loading-text">Loading...</p>
      </div>
    </div>
  );
}


export default LoadingPage;