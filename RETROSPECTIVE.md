# RETROSPECTIVE.md

## Trade-offs
- Simplicity vs production features: this starter favors clarity over advanced features (parallel fixtures, flaky-test handling, advanced reporting).
- No secrets manager included to keep the repository self-contained.

## Next 3 steps to scale for a banking product
1. **Security & Secrets**: Integrate HashiCorp Vault or cloud secret manager; encrypt sensitive test data.
2. **Stability & Performance**: Add retries for flaky tests, parallel execution with robust resource pooling, and performance smoke tests.
3. **Compliance & Reporting**: Centralized reporting (Allure + a report server), audit logs, and CI gates for approvals.

