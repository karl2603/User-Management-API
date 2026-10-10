
function Error404() {
   return (
      <div className="loading-page" role="alert">
        <div className="loading-content">
          <div className="loading-logo">
            <span className="loading-logo-text">User Management</span>
          </div>

          <h2 className="loading-error-title">Something went wrong</h2>
          <p className="loading-error-message">
            Failed to fetch data from the server. Please try again.
          </p>
        </div>
      </div>
    );
}

export default Error404